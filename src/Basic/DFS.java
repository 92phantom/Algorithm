package Basic;

public class DFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		
	}

	void dfs(int k){
		
		for(int i=1; i<=n; i++){
			
			if( G[k][i] && !visited[G[k][i]]){
				
				visited[G[k][i]] == true;
				
				dfs(G[k][i]);
				
			}
			
			return;
		}
		
	}
}
