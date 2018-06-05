# Rainbow-Table-Attack

The project is the implementation of the famous rainbow attack method.
Currently it is designed to generate rainbow tables for md5 4 digits numerical passwords and obviously
crack md5 hashes that are generated from 4 digits numerical input.

It can crack a single md5 hash given from the command line or it can crack multiple md5 hashes given from a text file with the name crackMe.txt

If i have enough time i will implement sha256 hash cracking, increase digits it can crack, add characters, polish the code and include much needed exception handling.

Update:

-Some exception handling.

-Generation of table's is now done in parallel, kept serial mode for demonstration purposes.

-Some clean up on the code has been done.


To-do:

-sha256.

-More exception handling.


If anybody is reading this any feedback is deeply appreciated.
Cheers!
