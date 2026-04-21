# 📘 AI & Algorithms Practicals – Input Examples (Java)

This README provides sample inputs and expected outputs for all implemented programs. Use these to test your code and for lab/viva reference.

---

## 🔹 1. Breadth First Search (BFS)

### Input Format
```
V E
u v (E lines)
start_vertex
```

### Example Input
```
5 4
0 1
0 2
1 3
2 4
0
```

### Expected Output
```
0 1 2 3 4
```

---

## 🔹 2. Depth First Search (DFS)

### Example Input
```
5 4
0 1
0 2
1 3
2 4
0
```

### Expected Output
```
0 1 3 2 4
```

---

## 🔹 3. A* Algorithm (8 Puzzle)

### Input Format
3×3 matrix (0 = blank)

### Example Input
```
1 2 3
4 5 6
7 0 8
```

### Expected Output
```
Solved!
```

---

## 🔹 4. A* Algorithm (Maze Pathfinding)

### Input Format
```
n m
grid (0 = free, 1 = blocked)
start_x start_y
target_x target_y
```

### Example Input
```
3 3
0 0 0
1 1 0
0 0 0
0 0
2 2
```

### Expected Output
```
Path Found
```

---

## 🔹 5. Selection Sort (Greedy)

### Input Format
```
n
array elements
```

### Example Input
```
5
64 25 12 22 11
```

### Expected Output
```
[11, 12, 22, 25, 64]
```

---

## 🔹 6. Prim's Minimum Spanning Tree

### Input Format
Adjacency Matrix

### Example Input
```
3
0 2 3
2 0 1
3 1 0
```

### Expected Output
```
MST Cost: 3
```

---

## 🔹 7. Kruskal's Minimum Spanning Tree

### Input Format
```
V E
u v weight
```

### Example Input
```
4 5
0 1 10
0 2 6
0 3 5
1 3 15
2 3 4
```

### Expected Output
```
MST Cost: 19
```

---

## 🔹 8. N-Queens Problem

### Input Format
```
N
```

### Example Input
```
4
```

### Expected Output
```
[0, 1, 0, 0]
[0, 0, 0, 1]
[1, 0, 0, 0]
[0, 0, 1, 0]
```

---

## 🔹 9. Graph Coloring Problem

### Input Format
```
V
Adjacency Matrix
m (colors)
```

### Example Input
```
4
0 1 1 1
1 0 1 0
1 1 0 1
1 0 1 0
3
```

### Expected Output
```
[1, 2, 3, 2]
```
