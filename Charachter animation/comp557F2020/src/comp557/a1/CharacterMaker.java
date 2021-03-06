package comp557.a1;

import javax.swing.JTextField;

import mintools.parameters.BooleanParameter;

//**** Marwen Kraiem 260955202 ****//


public class CharacterMaker {

	static public String name = "Player 007! - Marwen KRAIEM 260955202";
	
	// TODO: Objective 8: change default of load from file to true once you start working with xml
	static BooleanParameter loadFromFile = new BooleanParameter( "Load from file (otherwise by procedure)", true );
	static JTextField baseFileName = new JTextField("data/a1data/character");
	
	/**
	 * Creates a character, either procedurally, or by loading from an xml file
	 * @return root node
	 */
	static public GraphNode create() {
		
		if ( loadFromFile.getValue() ) {
			// TODO: Objectives 6: create your character in the character.xml file 
			return CharacterFromXML.load( baseFileName.getText() + ".xml");
		} else {
			// TODO: Objective 3,4,5,6: test DAG nodes by creating a small DAG in the CharacterMaker.create() method 
						
			// Use this for testing, but ultimately it will be more interesting
			// to create your character with an xml description (see example).
			
			// Here we just return null, which will not be very interesting, so write
			// some code to create a test or partial character and return the root node.

			FreeJoint part0 = new FreeJoint("part0");

			RotaryJoint part1 = new RotaryJoint("part1",  0,  1,  0,  1.0,  0.5, 0,  -180,  180);			
			SphericalJoint part2 = new SphericalJoint("part2", 0.5,0.5, 0, -90, 90, -20, 20, -100, 100);
			BodySphere sphere = new BodySphere( "sphere", 0, 0, 0, 0.5, 0.5, 0.5, 1, 0.5, 0.5, 0.2, 0.3, 0.5 );
			BodyBox box = new BodyBox( "box", 0, 0, 0, 0.5, 0.5, 0.5, 1, 0.5, 0.5, 0.8, 0.2, 0.2);

			part2.add(sphere);
			part1.add(part2);
			part1.add(box);
			part0.add(part1);

			return part0;
		}
	}
}
