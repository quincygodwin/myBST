package myBST;

public class BST implements BST_Interface {

	public BST_Node root;
	  int size;
	  
	  public BST(){ size=0; root=null; }
	  
	  @Override
	  public BST_Node getRoot(){ return root; }

	@Override
	public boolean insert(String s) {
		if(root==null){
			root=new BST_Node(s);
			size++;
			return true;
		} else if(root.insertNode(s)){
			size++;
			return true;
		} else return false;
	}

	@Override
	public boolean remove(String s) {
		if(root==null){
			return false;
		} 
		int cmp = s.compareTo(root.data);
		if(cmp==0){
			root=null;
			size--;
			return true;
		}else if(cmp>0){
			if(root.removeNode(s, root, true)){
				size--;
				return true;
			} else return false;
		} else if(root.removeNode(s, root, false)){
			size--;
			return true;
		} else return false;
	}

	@Override
	public String findMin() {
		return root.findMin().data;
	}

	@Override
	public String findMax() {
		return root.findMax().data;
	}

	@Override
	public boolean empty() {
		if(size==0||root==null){
			return true;
		} else return false;
	}

	@Override
	public boolean contains(String s) {
		if(root==null){
			return false;
		} else return root.containsNode(s);
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public int height() {
		return root.getHeight(root);
	}
	
	
}
