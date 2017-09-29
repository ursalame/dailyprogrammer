day(1,"first").
day(2,"second").
day(3,"third").
day(4,"fourth").
day(5,"fifth").
day(6,"sixth").
day(7,"seventh").
day(8,"eighth").
day(9,"ninth").
day(10,"tenth").
day(11,"eleventh").
day(12,"twelfth").

item(1,"1 Partridge in a Pear Tree").
item(2,"2 Turtle Doves").
item(3,"3 French Hens").
item(4,"4 Calling Birds").
item(5,"5 Golden Rings").
item(6,"6 Geese a Laying").
item(7,"7 Swans a Swimming").
item(8,"8 Maids a Milking").
item(9,"9 Ladies Dancing").
item(10,"10 Lords a Leaping").
item(11,"11 Pipers Piping").
item(12,"12 Drummers Drumming").

describeItem(0):-!.	
describeItem(X) :- 
	item(X,I),
	write(I), nl,
	Y is X-1,
	(Y = 1 -> write("and ");true),
	describeItem(Y)
	.

sing(13):-!.
sing(X):- 
	day(X, D),
	write("On the "),
	write(D),
	write(" day of Christmas"), nl,
	write("my true love sent to me:"), nl,
	describeItem(X),nl,
	Y is X+1, 
	sing(Y)
	.

sing():-sing(1).
