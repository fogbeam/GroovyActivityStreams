package org.fogbeam.example.protocol.activitystreams;

import java.text.SimpleDateFormat

import org.fogbeam.protocol.activitystreams.ActivityStreamEntry
import org.fogbeam.protocol.activitystreams.Actor
import org.fogbeam.protocol.activitystreams.Image
import org.fogbeam.protocol.activitystreams.Target
import org.springframework.context.ApplicationContext
import org.springframework.context.support.ClassPathXmlApplicationContext
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate

public class PostActivityStreamItem
{

	public static void main( String[] args )
	{
		
		ApplicationContext appContext = new ClassPathXmlApplicationContext( "applicationContext.xml" );
		
		RestTemplate restTemplate = appContext.getBean( "restTemplate", RestTemplate.class );
		
		SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd'T'HH:mm:ssZ" );
		
		ActivityStreamEntry newEntry = new ActivityStreamEntry();
		newEntry.setTitle(  "Testing ActivityStrea.ms integration" );
		newEntry.setContent( "Making sure this works as JSON" );
		newEntry.setPublished( sdf.format( new Date() ) );
		
		newEntry.setUrl( "http://example.com/testing" );
		newEntry.setVerb( "test_rest_api" );
		
		Actor actor = new Actor();
		actor.setId( "testuser3" );
		actor.setObjectType( "User" );
		actor.setDisplayName( "" );
		actor.setUrl( "" );
		Image actorImage = new Image();
		actorImage.setHeight( "" );
		actorImage.setUrl( "" );
		actorImage.setWidth( "" );
		actor.setImage( actorImage );
		
		newEntry.setActor( actor );
		
		org.fogbeam.protocol.activitystreams.Object object = new org.fogbeam.protocol.activitystreams.Object();
		object.setObjectType( "StatusUpdate" );
		object.setUrl( "" );
		object.setId( "" );
		newEntry.setObject(  object );
		
		Target target = new Target();
		target.setId( "abc123" );
		target.setObjectType( "User" );
		target.setDisplayName( "" );
		target.setUrl( "" );
		
		newEntry.setTarget( target );
		
		
		ResponseEntity<String> response = 
			restTemplate.postForEntity( 
					"http://localhost:8080/quoddy2/api/activitystreamentry",
					newEntry, String.class );
		
		String responseText = response.getBody();		
		
		System.out.println( "done with response: " + responseText );
	}
}
