import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


/**
 * @author Rohit
 *
 */

public class Graph {
	
	/** Method to add connection between two entities
	 * @param entityFirst :first entity 
	 * @param entitySecond :second entity
	 */
	public void addEdge(Entity entityFirst, Entity entitySecond) {
		Iterator<Entity> iteratorObj1 = Processing.nodeSet.iterator();	//Iterating list of questions
		while (iteratorObj1.hasNext()) {
			if(iteratorObj1.next().getEmail().equals(entitySecond.getEmail())){
				if(Processing.friendMap.containsKey(entityFirst.getEmail())) {
					if(!Processing.friendMap.get(entityFirst.getEmail()).contains(entitySecond.getEmail())) {
						Processing.friendMap.get(entityFirst.getEmail()).add(entitySecond.getEmail());
						System.out.println(entitySecond.getEmail()+" is now friend of you");
					}else if(Processing.friendMap.get(entityFirst.getEmail()).contains(entitySecond.getEmail())){
						System.out.println(entitySecond.getEmail()+" is already friend of you");
					}else {
						System.out.println(entitySecond.getEmail()+" does not exist");
					}
				} else{
					Iterator<Entity> iteratorObj2 = Processing.nodeSet.iterator();	//Iterating list of questions
					while (iteratorObj2.hasNext()) {
						if(iteratorObj2.next().getEmail().equals(entityFirst.getEmail())){
							Set<String> set=new HashSet<String>();
							set.add(entitySecond.getEmail());
							Processing.friendMap.put(entityFirst.getEmail(),set);
							System.out.println(entitySecond.getEmail()+" is now friend of you");
						}
					}
				}
			}
		}
	}
	
	/** method for removing connection between these two entity
	 * @param entityFirst :first entity 
	 * @param entitySecond :second entity
	 */
	public void removeEdge(Entity entityFirst, Entity entitySecond) {
		if(Processing.friendMap.containsKey(entityFirst.getEmail())) {
			if(Processing.friendMap.get(entityFirst.getEmail()).contains(entitySecond.getEmail())) {
				Processing.friendMap.get(entityFirst.getEmail()).remove(entitySecond.getEmail());
				System.out.println(entitySecond.getEmail()+" is removed from your Friend list");
			}
			else{
				System.out.println(entitySecond.getEmail()+" is not friend of you");
			}
			
		}else {
			System.out.println(entityFirst.getEmail()+" does not exist");
		}
	}
	
	
	/**Add entity to Set
	 * @param entity: entity to be added in set
	 */
	void addNode(Entity entity) {
		Processing.nodeSet.add(entity);
		System.out.println("the entity was successfully added to the network.");
	}
	
	/**remove element from Set
	 * @param entity: entity to be removed from set
	 */
	void removeNode(Entity entity) {
		Processing.nodeSet.remove(entity);
		Processing.friendMap.remove(entity);

		System.out.println("the person was successfully removed from the network.");
	}
	
	
	/**Method to search an entity in the network
	 * @param name : name to be searched
	 */
	void searchByName(String name) {
		int i=0;
			for (Entity entity : Processing.nodeSet) {
				
				/* if Entity is person */
				if(entity instanceof Person) {
					Person person=(Person)entity;
					if(person.getName().equalsIgnoreCase(name)){
					System.out.println("the person details are :");
					System.out.println("   name : " + person.getName());
					System.out.println("   phone : " + person.getPhone());
					System.out.println("   email : " + person.getEmail());
					System.out.println("   school : " + person.getSchool());
					System.out.println("   college : " + person.getCollege() + "\n");
						for(String interest:person.getInterests()){
							System.out.println("   interest in : " +interest + "\n");
						}
						break;
					}
				}
				/* If entity is organization */
				else {
					Organization organization=(Organization)entity;
					if(organization.getName().equalsIgnoreCase(name)){
						System.out.println("the person details are :");
						System.out.println("   name : " + organization.getName());
						System.out.println("   phone : " + organization.getPhone());
						System.out.println("   email : " + organization.getEmail());
						for(String interest:organization.getCourses()){
							System.out.println("   courses are : " +interest + "\n");
						}
						for(String interest:organization.getFaculty()){
							System.out.println("   Faculties are : " +interest + "\n");
						}
						for(String interest:organization.getPlacements()){
							System.out.println("   Placements are : " +interest + "\n");
						}
						break;
					}
				}
				i++;
			}
			if(i>=Processing.nodeSet.size()) {//if no such name exist
				System.out.println(name+" does not exist");
			}
	}
}
