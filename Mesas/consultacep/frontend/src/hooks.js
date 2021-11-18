import { useCallback, useEffect, useRef } from "react"

export const useTimeout = (callback, delay) => {
  const cbRef = useRef(callback)
  const timeoutRef = useRef()

  useEffect(() => {
    cbRef.current = callback
  }, [callback])

  const set = useCallback(() => {
    timeoutRef.current = setTimeout(() => cbRef.current(), delay)
  }, [delay])

  const clear = useCallback(() => {
    timeoutRef.current && clearTimeout(timeoutRef.current)
  }, [])

  useEffect(() => {
    set()
    return clear
  }, [delay, set, clear])

  const reset = useCallback(() => {
    clear()
    set()
  }, [clear, set])

  return { reset, clear }
}

export const useDebounce = (callback, delay, dependencies) => {
  const { reset, clear } = useTimeout(callback, delay)
  useEffect(reset, [...dependencies, reset])
  // eslint-disable-next-line
  useEffect(clear, [])
}