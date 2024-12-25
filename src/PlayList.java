package src;

class Node {
    SongNode song;
    Node next;
    

    Node(SongNode song) {
        this.song = song;
        this.next = null;
    }
}

public class PlayList {
    private Node top;

    public void addTop(SongNode song) {
        Node newNode = new Node(song);
        newNode.next = top;
        top = newNode;
    }

    public void popTop(){
        if (top != null)
        top = top.next;
    }

    public void enqueue(SongNode song) {
        Node newNode = new Node(song);
        if (top == null) {
            top = newNode;
        } else {
            Node current = top;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;        
        }
    }
    public void Musikplay() {
        if (top != null) {
            System.out.println();
            System.out.println("             Now Playing         ");
            System.out.println(" |> " + top.song.title + " - " + top.song.author);
            System.out.println();
            System.out.println("0:00 |=>-----------------------|" + top.song.minutes +":"+ top.song.seconds);
            System.out.println();
            System.out.println("====================================");
            System.out.println();
        }
    }
    

    public void viewHistory() {
        System.out.println("================================");
        System.out.println("      Recently Played Songs     ");
        System.out.println("================================");
        System.out.println();
        if (top == null) {
            System.out.println("No songs played yet.");
            return;
        }

        Node current = top;
        int Nomer_lagu = 1;

        while (current != null) {
            System.out.println("  " + Nomer_lagu + " | " + current.song.title + " - " + current.song.author + " (" + current.song.releaseYear + ")");
            System.out.println("        " + current.song.minutes +":"+ current.song.seconds );
            Nomer_lagu++;
            current = current.next;
        }
    }
}
