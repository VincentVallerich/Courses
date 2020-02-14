def pigeonhole_sort(a) -> None:
    """Pigeonhole sort."""
    mi = min(a)
    size = max(a) - mi + 1
    holes = [0] * size
    for x in a:
        holes[x - mi] += 1
    i = 0
    for count in range(size):
        while holes[count] > 0:
            holes[count] -= 1
            a[i] = count + mi
            i += 1