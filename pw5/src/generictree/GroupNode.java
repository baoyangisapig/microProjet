package generictree;

public class GroupNode<T> extends AbstractTreeNode<T> {
  private TreeNode<T> left;
  private TreeNode<T> right;

  private TreeNode<T> getLeft() {
    return left;
  }

  private TreeNode<T> getRight() {
    return right;
  }

  @Override
  public TreeNode<T> addChild(TreeNode<T> child) {
    if(child==null||(getLeft()!=null&&getRight()!=null))return this;
      if(left!=null){
        left=child;
      }
      else{
        right=child;
      }
      return this;
  }

}
