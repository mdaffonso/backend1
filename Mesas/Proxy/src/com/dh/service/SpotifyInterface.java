package com.dh.service;

import com.dh.model.Song;
import com.dh.model.User;

public interface SpotifyInterface {
    public void downloadSong(User user, Song song);
}
