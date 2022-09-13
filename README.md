# WireWorld
Wireworld cellular automaton

A Wireworld cell can be in one of four different states, usually numbered 0–3 in software, modeled by colors in the examples here:

empty (black),
electron head (blue),
electron tail (red),
conductor (yellow).
As in all cellular automata, time proceeds in discrete steps called generations (sometimes "gens" or "ticks"). Cells behave as follows:

empty → empty,
electron head → electron tail,
electron tail → conductor,
conductor → electron head if exactly one or two of the neighbouring cells are electron heads, otherwise remains conductor.
Wireworld uses what is called the Moore neighborhood, which means that in the rules above, neighbouring means one cell away (range value of one) in any direction, both orthogonal and diagonal.

These simple rules can be used to construct logic gates.


![example picture](https://upload.wikimedia.org/wikipedia/commons/1/13/Wireworld_XOR-gate.gif)


Source: https://en.wikipedia.org/wiki/Wireworld


