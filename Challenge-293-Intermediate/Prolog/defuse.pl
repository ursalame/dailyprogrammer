defuse([white|X]) :- white(X).
defuse([red|X]) :- red(X).

white([white, red|X]) :- defuse(X).
white([white, black|X]) :- black(X).
white([orange|X]) :- orange(X).

orange([green]).
orange([orange|X]) :- orange(X).
orange([black|X]) :- black(X).

green([orange]).
green([green|X]) :- green(X).
green([black|X]) :- black(X).

black([green|X]) :- green(X).
black([orange|X]) :- orange(X).
black([black|X]) :- black(X).

red([black|X]) :- black(X).
red([red|X]) :- defuse(X).

defusable([], []).
defusable([(C,N)|X], L) :- 
	defusable(X,LN), 
	repl(C,N,LC),
	append(LC,LN, L).
	
defusable(X) :- 
	defusable(X, L), 
	permutation(L, PL),
	defuse(PL),!.

repl(X, N, L) :- length(L, N), maplist(=(X), L).
