package src;
public class FavoriteTree {
    private TreeNode root;

    public void addFavorite(SongNode song) {
        root = addRecursive(root, song);
    }

    private TreeNode addRecursive(TreeNode current, SongNode song) {
        if (current == null) return new TreeNode(song);

        if (song.title.compareToIgnoreCase(current.song.title) < 0) {
            current.left = addRecursive(current.left, song);
        } else {
            current.right = addRecursive(current.right, song);
        }
        return current;
    }

    public void displayFavorites() {
        System.out.println("--- Favorite Songs ---");
        inOrderTraversal(root);
    }

    private void inOrderTraversal(TreeNode node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.println(node.song);
            inOrderTraversal(node.right);
        }
    }
}
