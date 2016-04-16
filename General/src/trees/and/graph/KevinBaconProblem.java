package trees.and.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class KevinBaconProblem {
	
	private Set<ActorNode> visited = new HashSet<ActorNode>();
	private Map<ActorNode, ActorNode> relationMap = new HashMap<ActorNode,ActorNode>();
	
	public int separationNumber(ActorNode sourceActor, ActorNode destActor){
		if(sourceActor == null || destActor == null) return -1;
		int count = 0;
		Queue<ActorNode> trackerQueue = new LinkedList<ActorNode>();
		trackerQueue.add(sourceActor);
		while(!trackerQueue.isEmpty()){
			ActorNode currActor = trackerQueue.poll();
			if(!visited.contains(currActor)){
				visited.add(currActor);
			}
			for(ActorNode coStar : currActor.coStars){
				if(!visited.contains(coStar)){
					trackerQueue.add(coStar);
					relationMap.put(coStar, currActor); //sorta child-to-parent
				}
			}
		}
		
		if(visited.contains(destActor)){
			ActorNode temp = destActor;
			while(temp != sourceActor){
				temp = relationMap.get(temp);
				count++;
			}
		}
		return count;
	}
	
	
	public class ActorNode{
		String name;
		Set<ActorNode> coStars;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Set<ActorNode> getCoStars() {
			return coStars;
		}
		public void setCoStars(Set<ActorNode> coStars) {
			this.coStars = coStars;
		}
		
		
	}

}
