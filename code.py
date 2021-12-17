class Func:
	def sum(self, *a):
	    sum = 0
	    if len(a) == 1:
	        return a[0]+10
	    for x in a:
	        sum+=x
	    return sum
	    
	def diff(self,*a):
	    diff = 0
	    if len(a) == 1:
	        return a[0]
	    elif len(a) == 2:
	        return a[0] - a[1]
	    else:
	        return "too much data"
     
