package LeetCode_Classic150

// 并查集
func calcEquation(equations [][]string, values []float64, queries [][]string) []float64 {
	record := map[string]int{}
	for _, equation := range equations {
		var1, var2 := equation[0], equation[1]
		if _, has := record[var1]; !has {
			record[var1] = len(record)
		}
		if _, has := record[var2]; !has {
			record[var2] = len(record)
		}
	}
	fa := make([]int, len(record))
	w := make([]float64, len(record))
	for i := range fa {
		fa[i] = i
		w[i] = 1
	}
	var find func(int) int
	find = func(x int) int {
		if fa[x] != x {
			f := find(fa[x])
			w[x] *= w[fa[x]]
			fa[x] = f
		}
		return fa[x]
	}
	merge := func(from, to int, val float64) {
		fFrom, fTo := find(from), find(to)
		w[fFrom] = val * w[to] / w[from]
		fa[fFrom] = fTo
	}
	for i, equation := range equations {
		merge(record[equation[0]], record[equation[1]], values[i])
	}
	res := make([]float64, len(queries))
	for i, query := range queries {
		start, hasS := record[query[0]]
		end, hasE := record[query[1]]
		if hasS && hasE && find(start) == find(end) {
			res[i] = w[start] / w[end]
		} else {
			res[i] = -1.0
		}
	}
	return res
}
