package LeetCode_Classic150

type Node struct {
	Val       int
	Neighbors []*Node
}

func cloneGraph(node *Node) *Node {
	record := make(map[*Node]*Node)
	var dfs func(node *Node) *Node
	dfs = func(node *Node) *Node {
		if node == nil {
			return node
		}
		if _, ok := record[node]; ok {
			return record[node]
		}
		cloneNode := &Node{node.Val, []*Node{}}
		record[node] = cloneNode
		for _, neighbor := range node.Neighbors {
			cloneNode.Neighbors = append(cloneNode.Neighbors, dfs(neighbor))
		}
		return cloneNode
	}
	return dfs(node)
}
