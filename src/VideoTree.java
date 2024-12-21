package src;

class VideoTree {
    private VideoNode root;

    public VideoTree() {
        root = null;
    }

    // Menambahkan film ke tree di lokasi tertentu
    public void addVideoAfter(String previousTitle, String title, String director, String type, int releaseYear, int durationMinutes, int durationSeconds) {
        VideoNode newNode = new VideoNode(title, director, type, releaseYear, durationMinutes, durationSeconds);
        VideoNode previousNode = searchVideo(previousTitle);

        if (previousNode == null) {
            System.out.println("Film dengan judul " + previousTitle + " tidak ditemukan.");
            return;
        }

        if (previousNode.left == null) {
            previousNode.left = newNode;
        } else if (previousNode.right == null) {
            previousNode.right = newNode;
        } else {
            System.out.println("Node penuh, menambahkan di lokasi terjauh.");
            addVideoRecursively(root, newNode);
        }
    }

    // Menambahkan film ke tree
    public void addVideo(String title, String director, String type, int releaseYear, int durationMinutes, int durationSeconds) {
        VideoNode newNode = new VideoNode(title, director, type, releaseYear, durationMinutes, durationSeconds);
        if (root == null) {
            root = newNode;
        } else {
            addVideoRecursively(root, newNode);
        }
    }

    private void addVideoRecursively(VideoNode current, VideoNode newNode) {
        if (newNode.title.compareTo(current.title) < 0) {
            if (current.left == null) {
                current.left = newNode;
            } else {
                addVideoRecursively(current.left, newNode);
            }
        } else {
            if (current.right == null) {
                current.right = newNode;
            } else {
                addVideoRecursively(current.right, newNode);
            }
        }
    }

    // Menampilkan semua film dalam tree (in-order traversal)
    public void displayAllVideos() {
        if (root == null) {
            System.out.println("Daftar film kosong.");
        } else {
            displayAllVideosRecursively(root);
        }
    }

    private void displayAllVideosRecursively(VideoNode node) {
        if (node != null) {
            displayAllVideosRecursively(node.left);
            System.out.println("Title: " + node.title + ", Director: " + node.director);
            displayAllVideosRecursively(node.right);
        }
    }

    // Mencari film berdasarkan judul
    public VideoNode searchVideo(String title) {
        return searchVideoRecursively(root, title);
    }

    private VideoNode searchVideoRecursively(VideoNode current, String title) {
        if (current == null) {
            return null;
        }
        if (title.equals(current.title)) {
            return current;
        }
        if (title.compareTo(current.title) < 0) {
            return searchVideoRecursively(current.left, title);
        } else {
            return searchVideoRecursively(current.right, title);
        }
    }

    // Menonton film
    public void watchVideo(String title) {
        VideoNode node = searchVideo(title);

        if (node == null) {
            System.out.println("Film tidak ditemukan.");

        } else {
            VideoPlay(node);
            if (node.left != null) {
                System.out.println("Film terkait (kiri): " + node.left.title);
            } else {
                System.out.println("Film tidak memiliki sequel di kiri.");
            }
            if (node.right != null) {
                System.out.println("Film terkait (kanan): " + node.right.title);
            } else {
                System.out.println("Film tidak memiliki sequel di kanan.");
            }
        }
    }

    public void layar (){
        System.out.println("0--------------------------------------------------0");
        System.out.println("|                                                  |");
        System.out.println("|                                                  |");
        System.out.println("|                                                  |");
        System.out.println("|                                                  |");
        System.out.println("|                                                  |");
        System.out.println("|                          |>                      |");
        System.out.println("|                                                  |");
        System.out.println("|                                                  |");
        System.out.println("|                                                  |");
        System.out.println("|                                                  |");
        System.out.println("|                                                  |");
        System.out.println("0--------------------------------------------------0");
    }

    public void VideoPlay( VideoNode node) {
        if (node != null) {
            System.out.println("====================================");
            System.out.println("               Now Playing          ");
            System.out.println("====================================");
            System.out.println("=> " + node.title + " - " + node.director);
            System.out.println("=> Release Year: " + node.releaseYear);
            System.out.println("=> Genre: " + node.type);
            System.out.println("====================================");
    
            //menampilkan layar
            layar();

            // Simulasi waktu berjalan
            int totalSeconds = node.durationMinutes * 60 + node.durationSeconds; // Menghitung total durasi dalam detik
            int progressBarLength = 50; // Panjang progress bar
            int currentSeconds = 0; // Waktu saat ini
            
            while (currentSeconds <= totalSeconds) {
                // Menghitung berapa banyak progress bar yang sudah terisi
                int filledLength = (int) ((double) currentSeconds / totalSeconds * progressBarLength);
                
                // Progress bar bergerak
                String progressBar = "0:00 ";
                progressBar += "|"; 
                
                for (int i = 0; i < filledLength; i++) {
                    progressBar += "="; // Bagian progress yang terisi
                }
                
                progressBar += ">";
                
                for (int i = filledLength; i < progressBarLength; i++) {
                    progressBar += "-"; // Bagian progress yang belum terisi
                }
                
                progressBar += "| ";
                
                // Menghitung menit dan detik saat ini
                int currentMinutes = currentSeconds / 60;
                int currentRemainingSeconds = currentSeconds % 60;
                String timeNow = String.format("%02d:%02d", currentMinutes, currentRemainingSeconds);
                
                // Menampilkan waktu saat ini dan total durasi
                progressBar += timeNow + " / " + String.format("%02d:%02d", node.durationMinutes, node.durationSeconds);
                
                // Menampilkan progress bar
                System.out.print("\r" + progressBar); // \r untuk menimpa baris sebelumnya
                try {
                    Thread.sleep(1); // Delay 1 detik
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
                currentSeconds++;
            }
    
            System.out.println("\n Video selesai diputar! ");
        } else {
            System.out.println("Tidak ada video di dalam daftar putar!");
        }
    }
    

    // Menghapus film
    public void deleteVideo(String title) {
        root = deleteVideoRecursively(root, title);
    }

    private VideoNode deleteVideoRecursively(VideoNode current, String title) {
        if (current == null) {
            return null;
        }

        if (title.equals(current.title)) {
            if (current.left == null && current.right == null) {
                return null;
            }
            if (current.right == null) {
                return current.left;
            }
            if (current.left == null) {
                return current.right;
            }
            VideoNode smallestValue = findSmallestValue(current.right);
            current.title = smallestValue.title;
            current.right = deleteVideoRecursively(current.right, smallestValue.title);
            return current;
        }
        if (title.compareTo(current.title) < 0) {
            current.left = deleteVideoRecursively(current.left, title);
            return current;
        }
        current.right = deleteVideoRecursively(current.right, title);
        return current;
    }

    private VideoNode findSmallestValue(VideoNode root) {
        return root.left == null ? root : findSmallestValue(root.left);
    }

    public void searchAndDisplayVideo(String title) {
        VideoNode node = searchVideo(title);
        if (node == null) {
            System.out.println("Film dengan judul \"" + title + "\" tidak ditemukan.");
        } else {
            System.out.println("\nFilm dengan judul " + title +" ditemukan, berikut informasi lengkapnya:");
            System.out.println("\n====================================");
            System.out.println("          Informasi Film           ");
            System.out.println("====================================");
            System.out.println("Judul         : " + node.title);
            System.out.println("Sutradara     : " + node.director);
            System.out.println("Genre         : " + node.type);
            System.out.println("Tahun Rilis   : " + node.releaseYear);
            System.out.println("Durasi        : " + node.durationMinutes + ":" + String.format("%02d", node.durationSeconds));
            System.out.println("------------------------------------");
            System.out.println("Film Terkait:");

            if (node.left != null) {
                System.out.println("\nSequel Kiri:");
                System.out.println("- " + node.left.title + " (" + node.left.releaseYear + ")");
                System.out.println("  Sutradara: " + node.left.director);
            } else {
                System.out.println("\nTidak ada sequel di kiri");
            }
            
            if (node.right != null) {
                System.out.println("\nSequel Kanan:");
                System.out.println("- " + node.right.title + " (" + node.right.releaseYear + ")");
                System.out.println("  Sutradara: " + node.right.director);
            } else {
                System.out.println("\nTidak ada sequel di kanan");
            }
            System.out.println("====================================");
        }
    }
    
}
