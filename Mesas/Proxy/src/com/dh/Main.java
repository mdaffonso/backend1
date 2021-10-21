package com.dh;

import com.dh.model.Plan;
import com.dh.model.Song;
import com.dh.model.User;
import com.dh.service.impl.Spotify;

public class Main {

    public static void main(String[] args) {
        User u = new User("Matheus", Plan.PREMIUM);
        Song s = new Song("Fuel", "Metallica", "Reload");

        Spotify.download(u, s);
    }
}
