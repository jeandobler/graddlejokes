package com.udacity.gradle.builditbigger.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.udacity.gradle.builditbigger.JokeGenerator;

/** An endpoint class we are exposing */
@Api(
        name = "jokeEndpoint",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class JokeEndpoint {

    /** A simple endpoint method that takes a name and says Hi back */
    @ApiMethod(name = "getJoke")
    public Joke getJoke() {
        Joke response = new Joke();
        JokeGenerator genrator = new JokeGenerator();

        response.setData(genrator.getRandomJoke());
        return response;
    }



}
