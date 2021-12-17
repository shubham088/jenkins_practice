def sum(*a):
    sum = 0
    if len(a) == 1:
        return a[0]+10
    for x in a:
        sum+=x
    return sum 



def diff(*a):
    diff = 0
    if len(a) == 1:
        return a[0]
    elif len(a) == 2:
        return a[0] - a[1]
    else:
        return "too much data"

print("sum = ", sum(5,5))

print("sum = ", sum(10))

print("diff = ", diff(5))

print("diff = ", diff(6,3))

print("diff  = ", diff(5,6,7))
