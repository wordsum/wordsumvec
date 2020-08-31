# WordSumVec

An alpha release of a microservice to cache a word2vec build of 
a body of text along with a word2vec configuration. 
 
This tool enables other services to model the nearest words of a word within the cached word2vec.

The model and the code are continuing to be improved to work with WordSumStore, 
WordSumText and WordSumStory to add to the WordSum model to enable the automation of editing.

### UI

Currently, this uses Swagger interface if one needs a GUI to input.

http://localhost:8082/swagger-ui.html

### Launching 

1. ./gradlew bootRun

### Copyright

  Open Story License

  Story: WordSumVec
  Writer: Kalab J. Oster&trade;
  Copyright Holders: Kalab J. Oster&trade;
  copyright &copy; 2020 Kalab J. Oster&trade;

  Permission is granted by the Copyright Holders for humans or other intelligent agents to read, write, edit, publish
  and critique the Story if the humans or intelligent agents keep this Open Story License with the Story,
  and if another writer writes or edits the Story then the writer's name needs to be appended to the end of the Writer
  list of this Open Story License.
