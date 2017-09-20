# mutable-string

## Introduction
Often on interviews I ask a candidate if String in Java is mutable or immutable? Expected _standard_ answer that "In Java String is immutable". Good enough.

But I rather want to hear "In Java String is immutable if..." And here is a catch. There is a way to MAKE STRING MUTABLE AGAIN. If you are _familiar_ with Java internals you will figure out an answer pretty quickly. Next question [would be, if candidate gives me an expected answer, through haven't happened yet (after 10+ technical calls, from junior to architects :( )] - HOW TO MAKE STRING IMMUTABLE AGAIN (yeah, we need to go deeper).

If you are still curious and don't know an answer - you could check a source code.

## How to run

1. first git clone a repo:
  `git clone https://github.com/StShadow/mutable-string.git`
1. then build and run with maven:
   - `mvn mvn -q exec:exec` for mutable example
   - `mvn -q exec:exec -P hardened` for immutable again
1. alternatively you could run a testcase `me.anatoli.mutable.impl.DefaultMutatorTest`

## License

The project is licensed under two licenses - [Unlicense](https://unlicense.org/) and [WTFPL](http://www.wtfpl.net/)
