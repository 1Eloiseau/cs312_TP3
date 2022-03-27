## Change your name here:
MYNAME = Eloi_Donval__Martin_Boulin__Loic_Savornin

## DO NOT change below
SRC=Restaurant
HERE=$(PWD)
MAINCLASS=TestRestaurant
SRCJAVA=$(wildcard $(SRC)/*.java)
CLASSFILES = $(SRCJAVA:.java=.class)

all: run

# Compile
%.class: %.java
	javac $^

# Run
run: $(SRC)/$(MAINCLASS).class
	java $(SRC)/$(MAINCLASS)

tar: clean
	dir=$$(basename $$PWD/$$SRC) && cd .. && \
	tar cvfz "TP03-$(MYNAME).tgz" --exclude=".git" "$$dir"

clean:
	rm -f $(SRC)/*.class $(SRC)/*~ *~
