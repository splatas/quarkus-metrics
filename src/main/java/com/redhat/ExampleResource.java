package com.redhat;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.micrometer.core.annotation.Counted;
import io.micrometer.core.annotation.Timed;

@Path("/q-metrics")
public class ExampleResource {
	
	private List<String> songs = new ArrayList<String>();

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/hello")
    public String hello() {
    	System.out.println(" => hello: ");

        return "Hello RESTEasy !";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/getSongs")
    @Timed("time_get_songs")
    @Counted
    public List<String> getSongs() {
    	System.out.println(" => getSongs: songs=" + songs);
    	
    	return songs;
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/populateSongs")
    @Timed("time_populate_songs")
    @Counted
    public List<String> populateSongs() {
    	System.out.println(" => populateSongs.init: songs=" + songs);
    	
        if (songs.isEmpty()) {
        	songs.add("Highway to Hell");
        	songs.add("Walk");
        	songs.add("Jijiji");
        	
        	System.out.println(" => populateSongs: songs populated!");
		}
        
        System.out.println(" => populateSongs.end: songs=" + songs);
        
        return songs;
    }
    
}