package myBST;

public class BST_Node {

	String data;
	  BST_Node left;
	  BST_Node right;
	  BST_Node _parent;
	  
	  BST_Node(String data){ this.data=data; }
	  BST_Node(String data, BST_Node parent){
		  this.data = data;
		  this._parent = parent;
	  }

	  public String getData(){ return data; }
	  public BST_Node getLeft(){ return left; }
	  public BST_Node getRight(){ return right; }

	  
	  public boolean containsNode(String s){ 
		  int cmp = data.compareTo(s); 
		  if(cmp==0){
			   return true;
		   } else if(cmp>0){
			   if(!this.hasLeft()){
				   return false;
			   } else return left.containsNode(s);
		   } else if(cmp<0){
			   if(!this.hasRight()){
				   return false;
			   } else return right.containsNode(s);
		   }
		  return false;
	  }
	  
	  
	  public boolean insertNode(String s){ 
		  int cmp = data.compareTo(s);
		  if(cmp==0){
			  return false;
		  }
		  if(cmp>0){
			  if(this.hasLeft()){
				  return left.insertNode(s);
			  } else left = new BST_Node(s, this);
			  		 return true;
		  } else if(this.hasRight()){
			  return right.insertNode(s);
		  } else {
			  right = new BST_Node(s, this);
			  return true;	
		  }
		  }
	  
	  
	  public boolean removeNode(String s, BST_Node parent, boolean louie){ 
		  int cmp = data.compareTo(s);
		  if(cmp==0){
			  if(left==null&&right==null){
				  if(louie){
					  parent.left=null;
					  return true;
				  } else {
					  parent.right=null;
					  return true;
				  }
			  } else if(left==null&&right!=null){
				  if(louie){
				  parent.left=right;
				  return true;
				  } else {
					  parent.right=right;
					  return true;
				  }
			  } else if (left!=null&&right==null){
				  if(louie){
					  parent.left=left;
					  return true;
					  } else {
						  parent.right=left;
						  return true;
					  }
			  }else {
				  String place = right.findMin().getData();
				  removeNode(place, right.findMin()._parent, false);
				  data = place;
				  return true;
			  }
		  } else if(cmp>0){
			  if(this.hasLeft()){
				  return left.removeNode(s, this, true);
			  } else return false;
		  } else if(this.hasRight()){
			  return right.removeNode(s, this, false);
		  } else return false;
		  }
	  
	  public BST_Node findMin(){
		  if(this.hasLeft()){
			return  left.findMin();
		  } else return this;
		  }
	  
	  public BST_Node findMax(){
		  if(this.hasRight()){
			  return right.findMax();
		  } else return this;
		  }
	  
	  public int getHeight(BST_Node root){ 
		  if(root==null){return -1;}
		  return(1+Math.max(getHeight(root.left), getHeight(root.right)));
		  }
	  
	  
	  public boolean hasLeft(){
		  if(left!=null){
			  return true;
		  } else return false;
	  }
	  public boolean hasRight(){
		  if(right!=null){
			  return true;
		  } else return false;
	  }
	  
	  public BST_Node getParent(){
		  if(_parent==null){
			  return null;
		  }else return _parent;
	  }

	  public String toString(){
	    return "Data: "+this.data+", Left: "+((this.left!=null)?left.data:"null")
	            +",Right: "+((this.right!=null)?right.data:"null");
	  }
	
	
}
