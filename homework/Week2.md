Week2
=========

#### Difference between a byte stream and a character stream: ####
A stream is a way of sequentially accessing a file. A byte stream access the file byte by byte. A byte stream is suitable for any kind of file, however not quite appropriate for text files. For example, if the file is using a unicode encoding and a character is represented with two bytes, the byte stream will treat these separately and you will need to do the conversion yourself.

A character stream will read a file character by character. Character streams need to be given teh file's encoding in order to work properly.

*Cited:* http://stackoverflow.com/questions/3013996/byte-stream-and-character-stream

#### What happens when you serialize or deserialize an object? What are potential consequences of serialization?

Serialization is a mechanism by which you can save the state of an object by converting it to a bytestream.

In serialization, if any of the objects associated with the ToBeSerializedObject it will throw a NotSerializeableException

The Serialization mechanism generates an object graph, thus it determines whether the included object references are serializeable or not. This is a recusive process.

Serialization, however, breaks the opacity of an abstract data type by potentially exposing private implementation details. Trivial implementations which serialize all data members may violate encapsulation.

*Cited: * http://en.wikipedia.org/wiki/Serialization and http://www.allapplabs.com/interview_questions/java_interview_questions_3.htm#q9

#Assignment 2.3#

1) b, d, e
2) c
3) b, c, d, e
4) a
5) b, c, d, e
6) a
7) b
8) b
9) c, d, e
10) b
11) a
12) b // maybe c
13) a
14) c
15) c
16) a //?
17) a
18) d
19) //
20) b

