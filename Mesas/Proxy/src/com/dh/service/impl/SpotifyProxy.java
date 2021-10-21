package com.dh.service.impl;

import com.dh.model.Plan;
import com.dh.model.Song;
import com.dh.model.User;
import com.dh.service.SpotifyInterface;

public class SpotifyProxy implements SpotifyInterface {

    private SpotifyService spotifyService;

    public SpotifyProxy(SpotifyService s) {
        this.spotifyService = s;
    }

    @Override
    public void downloadSong(User user, Song song) {
        if (user.getPlan() != Plan.PREMIUM) {
            System.out.println("Somente usuários premium podem baixar músicas. =(");
            return;
        }

        spotifyService.downloadSong(user, song);
    }
}
