

import java.util.HashSet;
import java.util.Set;
/**
 * @author Rohit
 *
 */
public class SocialNetwork extends Graph {
	private static Graph graph=new Graph();
	
	/** Method to search an entity by name
	 * @param name : name to be searched
	 */
	public void  searchByName(String name) 
	{
		super.searchByName(name); 
	}
	
	/** Method to set friends of an entity
	 * @param entity :Get friend of these entity
	 * @return : return set of String containing friends
	 */
	public static Set<String> getFriends(Entity entity) 
	{
		if(Processing.friendMap.containsKey(entity.getEmail()))
			return Processing.friendMap.get(entity.getEmail());
		else
		{
			Set<String> set=new HashSet<String>();
			return set;
		}
	}
	
	/** Method for adding connection between two entity
	 * @param entityFirst :first entity 
	 * @param entitySecond :second entity
	 */
	public static void connect(Entity entityFirst, Entity entitySecond) {
		graph.addEdge(entityFirst, entitySecond);
	}
	
	/**MEthod for removing connection between two entity
	 * @param entityFirst :first entity 
	 * @param entitySecond :second entity
	 */
	public static void disconnect(Entity entityFirst, Entity entitySecond) {
		graph.removeEdge(entityFirst, entitySecond);
	}
	
	/**
	 * Method to show the social network
	 */
	public static void showNetwork() {
		int i = 1;
		for (Entity entity : Processing.nodeSet) 
		{
			/* if entity belong to person */
			if(entity instanceof Person)
			{
				Person person=(Person)entity;
				System.out.println(i+" Person details are :");
				System.out.println("   name : " + person.getName());
				System.out.println("   phone : " + person.getPhone());
				System.out.println("   email : " + person.getEmail());
				System.out.println("   school : " + person.getSchool());
				System.out.println("   college : " + person.getCollege() + "\n");
				for(String interest:person.getInterests())
				{
					System.out.println("   interest in : " +interest + "\n");
				}
			}	
			
			/*if entity is organization */
			else 
			{
				Organization organization=(Organization)entity;

				System.out.println(i+" Organization details are :");
				System.out.println("   name : " + organization.getName());
				System.out.println("   phone : " + organization.getPhone());
				System.out.println("   email : " + organization.getEmail());
				for(String interest:organization.getCourses())
				{
					System.out.println("   courses are : " +interest + "\n");
				}
				for(String interest:organization.getFaculty())
				{
					System.out.println("   Faculties are : " +interest + "\n");
				}
				for(String interest:organization.getPlacements())
				{
					System.out.println("   Placements are : " +interest + "\n");
				}
			}
			i++;
		}
	}
}
