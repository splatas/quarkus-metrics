package com.redhat;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//import io.micrometer.core.annotation.Timed;

@Path("/q-metrics")
public class ExampleResource {
	
	private List<String> songs = new ArrayList<String>();

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/hello")
    public String hello() {
    	System.out.println(" hello: ");

        return "Hello RESTEasy !";
    }
    
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/populateSongs")
    //@Timed("populate_songs")
    public void populateSongs() {
    	System.out.println(" populateSongs.init: songs=" + songs);
    	
        if (songs.isEmpty()) {
        	songs.add("Highway to Hell");
        	songs.add("Walk");
        	songs.add("Jijiji");
        	
        	System.out.println(" populateSongs: songs populated!");
		}
        
        System.out.println(" populateSongs.end: songs=" + songs);
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/getSongs")
    public List<String> getSongs() {
    	System.out.println(" getSongs: songs=" + songs);
    	
        return songs;
    }
}