Week2
=========

# Difference between a byte stream and a character stream: #
A stream is a way of sequentially accessing a file. A byte stream access the file byte by byte. A byte stream is suitable for any kind of file, however not quite appropriate for text files. For example, if the file is using a unicode encoding and a character is represented with two bytes, the byte stream will treat these separately and you will need to do the conversion yourself.

A character stream will read a file character by character. Character streams need to be given teh file's encoding in order to work properly.


