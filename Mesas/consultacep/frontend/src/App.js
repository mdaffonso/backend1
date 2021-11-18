import axios from "axios"
import { useEffect, useState } from "react"

function App() {

  const [ data, setData ] = useState({})
  const [ cep, setCep ] = useState("")

  const handleSubmit = async () => {
    try {
      const response = await axios(`./${cep}`)
      setData(response.data)
    } catch (error) {
      console.log(error)
    }
  }

  const handleChange = (event) => {
    const value = event.target.value.replace(/\D/g, "")
    setCep(value)
  }

  useEffect(() => {
    if (cep.length === 8) {
      handleSubmit()
    }
    // eslint-disable-next-line
  }, [cep])

  return (
    <>
      <h1>Digite um CEP para obter informações</h1>
      <input type="text" value={cep} onChange={handleChange} maxLength={8} />
      { data.erro ? (
        <h2>CEP não encontrado...</h2>
      ) : data.cep && (
        <ul>
          <li>{data.logradouro}</li>
          <li>Bairro {data.bairro}</li>
          <li>{data.localidade}, {data.uf}</li>
          <li>{data.cep}</li>
        </ul>
      )}
    </>
  );
}

export default App;
