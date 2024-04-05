package edu.stevens.cs522.chat.databases;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

import edu.stevens.cs522.chat.entities.Chatroom;
import edu.stevens.cs522.chat.entities.Message;
import edu.stevens.cs522.chat.entities.Peer;

// TODO add annotations for Repository pattern
@Dao
public interface MessageDao {
    @Query("SELECT Message.* FROM Message JOIN Chatroom ON Message.chatroom = Chatroom.name WHERE Chatroom.name = :chatroom")
    public abstract LiveData<List<Message>> fetchAllMessages(String chatroom);
    @Query("SELECT Message.* FROM Message JOIN Peer ON Message.sender = Peer.name WHERE Peer.name = :peerName")
    public LiveData<List<Message>> fetchMessagesFromPeer(String peerName);
    @Insert
    public void persist(Message message);

}
