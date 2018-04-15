# expriments

A Clojure library designed to make me famous

## Goal

Each number can be represented in base 2 (binary).  which is zeros and
ones. I want to categorize number based on the number of ones in
binary format, for example:
* one is 1 so the sum of digits(sod is 1)
* seven is 111 so sod is three
* fourteen is 1110 so sod is also three

each sod(sum of digits) is a level drawn as a circle and for now the radius of
circles gets bigger constantly. and numbers are places from small to
large (using < to determine) from top of circle and going clockwise.

I want to store data in a hash-map where
 *each key is a number (which is a level)*
 *each value is a sorted vector of numbers in that level (in increasing order)

note: I don't think the number of numbers that gets to a node (4 is
the result of 1 and 8, 2 is just from 4) because it is at most 2


# "Your english is bad!"
No it gets the job done
## License

Copyright © 2018 Don't cure

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
