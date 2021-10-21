package com.dh.service.impl;

import com.dh.model.Song;
import com.dh.model.User;

public class Spotify {
    static SpotifyService service = new SpotifyService();
    static SpotifyProxy proxy = new SpotifyProxy(service);

    public static void download(User user, Song song) {
        proxy.downloadSong(user, song);
    }
}
