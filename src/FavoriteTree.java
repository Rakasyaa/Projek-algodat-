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
        System.out.println("================================");
        System.out.println("        List Lagu Favorit       ");
        System.out.println("================================");

        if (root == null) {
            System.out.println("list masih kosong . . . ");
            System.out.println();
            System.out.println("Anda dapat menambahkan lagu terlebih dahulu");
            return;
        }

        inOrderTraversal(root);
    }

    private void inOrderTraversal(TreeNode node) {

        int Nomer_lagu = 1;
        if (node != null) {
            inOrderTraversal(node.left);
    
            System.out.println("  " + (++Nomer_lagu) + " | " + node.song.author + " - " + node.song.title + " (" + node.song.releaseYear + ")");
            System.out.println("        " + node.song.minutes +":"+ node.song.seconds );
            
            inOrderTraversal(node.right);
        }
    }
}
