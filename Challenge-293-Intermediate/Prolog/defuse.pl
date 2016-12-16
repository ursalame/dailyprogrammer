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

sequence([], []).
sequence([(C,N)|X], L) :- 
	sequence(X,LN), 
	repl(C,N,LC),
	append(LC,LN, L).
	
defusable(X, DL) :- 
	sequence(X, L), !, 
	findall(PL, (permutation(L, PL), defuse(PL)), DL).
	
defusable(X) :-	
		defusable(X, DL),
		DL \= [],
		write("Defused: "), write(DL).

defusable(_) :- write("Booom"), false.

repl(X, N, L) :- length(L, N), maplist(=(X), L).
