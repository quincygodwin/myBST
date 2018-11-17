package myBST;

public class BST_Playground {
	  
	  public static void main(String[]args){

		  BST _tree = new BST();
		  _tree.insert("A");
		  _tree.remove("A");
		  _tree.insert("B");
		  printLevelOrder(_tree);
	 
	  }

	  static void printLevelOrder(BST tree){ 
	    int h=tree.getRoot().getHeight(tree.getRoot());
	    for(int i=0;i<=h;i++){
	      printGivenLevel(tree.getRoot(), i);
	    }
	    
	  }
	  static void printGivenLevel(BST_Node root,int level){
	    if(root==null)return;
	    if(level==0)System.out.print(root.data+" ");
	    else if(level>0){
	      printGivenLevel(root.left,level-1);
	      printGivenLevel(root.right,level-1);
	    }
	  }
	  static void printInOrder(BST_Node root){
	  if(root!=null){
	    printInOrder(root.getLeft());
	    System.out.print(root.getData() + " ");
	    printInOrder(root.getRight());
	  }
	  }
	
	
	
}
