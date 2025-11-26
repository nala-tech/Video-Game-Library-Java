# Video-Game-Library-Java
Video game library application allowing users to add, remove, and manage their game collections using various data structures and algorithms. 

Data Structures Used:

Custom Class
VideoGame (fields: title, genre, id, next for linked list).

Linked List
The main library is a singly linked list (VideoGame.next).

Stack
removedGames (stores removed games for potential undo or history).

Queue
recentGames (a LinkedList used as a queue to track the last 5 added games).

HashMap
gameMap (maps id → VideoGame for O(1) lookup by ID).

ArrayList
Used for sorting by ID and collecting games by genre.

Algorithms Used:

Merge Sort (on linked list)
Implemented in mergeSortByTitle() for sorting games by title.
Uses getMiddle() (slow/fast pointer technique) and mergeByTitle() for merging.

Comparator-based Sort
sortGamesById() converts linked list to ArrayList and sorts using Comparator.comparingInt().

Linear Search
For checking duplicate titles when adding a game.
For searching games by genre.

HashMap Lookup
For searching and removing games by ID in O(1) time.

Queue Management
Maintains only the last 5 recent games using poll() when size exceeds 5.
