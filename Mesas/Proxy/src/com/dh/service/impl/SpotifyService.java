package com.dh.service.impl;

import com.dh.model.Song;
import com.dh.model.User;
import com.dh.service.SpotifyInterface;

public class SpotifyService implements SpotifyInterface {
    @Override
    public void downloadSong(User user, Song song) {
        System.out.println("Usuário " + user.getName() + " fez o download da música " + song.getTitle());
    }
}
