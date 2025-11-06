import 'package:flutter/material.dart';
import 'dart:async';

class ChatPage extends StatefulWidget {
  @override
  _ChatPageState createState() => _ChatPageState();
}

class _ChatPageState extends State<ChatPage> {
  final List<Map<String, dynamic>> _chatRooms = [
    {
      'city': 'İstanbul',
      'memberCount': 2847,
      'lastMessage': 'Zeynep: Şimdi hafif sarsıntı hissettim',
      'lastMessageTime': '2 dk önce',
    },
    {
      'city': 'Ankara',
      'memberCount': 1523,
      'lastMessage': 'Mehmet: Herhangi bir şey hisseden var mı?',
      'lastMessageTime': '5 dk önce',
    },
    {
      'city': 'İzmir',
      'memberCount': 1892,
      'lastMessage': 'Ayşe: Ege\'de 3.2 büyüklüğünde deprem oldu',
      'lastMessageTime': '12 dk önce',
    },
    {
      'city': 'Bursa',
      'memberCount': 856,
      'lastMessage': 'Can: Bilgi paylaşımı için teşekkürler',
      'lastMessageTime': '23 dk önce',
    },
    {
      'city': 'Antalya',
      'memberCount': 743,
      'lastMessage': 'Selin: Güneyde durum sakin görünüyor',
      'lastMessageTime': '34 dk önce',
    },
    {
      'city': 'Adana',
      'memberCount': 612,
      'lastMessage': 'Burak: Akşam saatlerinde hafif sarsıntı',
      'lastMessageTime': '1 saat önce',
    },
    {
      'city': 'Gaziantep',
      'memberCount': 534,
      'lastMessage': 'Elif: Her şey normal, herkes sakin',
      'lastMessageTime': '1 saat önce',
    },
    {
      'city': 'Konya',
      'memberCount': 487,
      'lastMessage': 'Murat: İyi akşamlar herkese',
      'lastMessageTime': '2 saat önce',
    },
    {
      'city': 'Kocaeli',
      'memberCount': 921,
      'lastMessage': 'Deniz: Marmara bölgesi sakin',
      'lastMessageTime': '3 saat önce',
    },
    {
      'city': 'Muğla',
      'memberCount': 398,
      'lastMessage': 'Zehra: Güzel bir gün geçirdik',
      'lastMessageTime': '4 saat önce',
    },
  ];

  void _openChatRoom(Map<String, dynamic> room) {
    Navigator.push(
      context,
      MaterialPageRoute(
        builder: (context) => ChatRoomScreen(room: room),
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        // Chat odaları listesi
        Expanded(
          child: ListView.builder(
            padding: EdgeInsets.all(16),
            itemCount: _chatRooms.length,
            itemBuilder: (context, index) {
              return _buildChatRoomCard(_chatRooms[index]);
            },
          ),
        ),
      ],
    );
  }

  Widget _buildChatRoomCard(Map<String, dynamic> room) {
    return Container(
      margin: EdgeInsets.only(bottom: 12),
      decoration: BoxDecoration(
        color: Colors.white,
        borderRadius: BorderRadius.circular(16),
        border: Border.all(color: Colors.grey[200]!),
        boxShadow: [
          BoxShadow(
            color: Colors.black.withOpacity(0.05),
            blurRadius: 8,
            offset: Offset(0, 2),
          ),
        ],
      ),
      child: Material(
        color: Colors.transparent,
        child: InkWell(
          onTap: () => _openChatRoom(room),
          borderRadius: BorderRadius.circular(16),
          child: Padding(
            padding: EdgeInsets.all(16),
            child: Row(
              children: [
                // Şehir ikonu
                Container(
                  width: 56,
                  height: 56,
                  decoration: BoxDecoration(
                    color: Color(0xFFFF3333).withOpacity(0.1),
                    borderRadius: BorderRadius.circular(12),
                  ),
                  child: Center(
                    child: Text(
                      room['city'][0],
                      style: TextStyle(
                        fontSize: 24,
                        fontWeight: FontWeight.bold,
                        color: Color(0xFFFF3333),
                      ),
                    ),
                  ),
                ),
                SizedBox(width: 16),

                // Oda bilgileri
                Expanded(
                  child: Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      Row(
                        children: [
                          Text(
                            room['city'],
                            style: TextStyle(
                              fontSize: 17,
                              fontWeight: FontWeight.bold,
                              color: Colors.black87,
                            ),
                          ),
                        ],
                      ),
                      SizedBox(height: 6),
                      Row(
                        children: [
                          Icon(Icons.people, size: 14, color: Colors.grey[600]),
                          SizedBox(width: 4),
                          Text(
                            '${room['memberCount']} üye',
                            style: TextStyle(
                              fontSize: 12,
                              color: Colors.grey[600],
                            ),
                          ),
                          SizedBox(width: 12),
                          Icon(Icons.access_time, size: 14, color: Colors.grey[600]),
                          SizedBox(width: 4),
                          Text(
                            room['lastMessageTime'],
                            style: TextStyle(
                              fontSize: 12,
                              color: Colors.grey[600],
                            ),
                          ),
                        ],
                      ),
                      SizedBox(height: 6),
                      Text(
                        room['lastMessage'],
                        style: TextStyle(
                          fontSize: 13,
                          color: Colors.grey[700],
                        ),
                        maxLines: 1,
                        overflow: TextOverflow.ellipsis,
                      ),
                    ],
                  ),
                ),

                // Chevron
                Icon(
                  Icons.chevron_right,
                  color: Colors.grey[400],
                  size: 24,
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }
}

// Chat Room Screen
class ChatRoomScreen extends StatefulWidget {
  final Map<String, dynamic> room;

  ChatRoomScreen({required this.room});

  @override
  _ChatRoomScreenState createState() => _ChatRoomScreenState();
}

class _ChatRoomScreenState extends State<ChatRoomScreen> {
  final TextEditingController _messageController = TextEditingController();
  final ScrollController _scrollController = ScrollController();
  int _remainingSeconds = 0;
  Timer? _timer;
  bool _canSendMessage = true;

  List<Map<String, dynamic>> _messages = [];

  @override
  void initState() {
    super.initState();
    _loadMessages();
  }

  void _loadMessages() {
    // Örnek mesajlar
    setState(() {
      _messages = [
        {
          'sender': 'Ahmet Y.',
          'message': 'Merhaba herkese, durum nasıl?',
          'time': '14:23',
          'isMe': false,
        },
        {
          'sender': 'Ayşe K.',
          'message': 'Selam! Her şey normal görünüyor.',
          'time': '14:25',
          'isMe': false,
        },
        {
          'sender': 'Sen',
          'message': 'İyi akşamlar, şimdi bir sarsıntı hissettim.',
          'time': '14:27',
          'isMe': true,
        },
        {
          'sender': 'Mehmet D.',
          'message': 'Ben de hissettim, hafif bir sallanma vardı.',
          'time': '14:28',
          'isMe': false,
        },
        {
          'sender': 'Zeynep S.',
          'message': 'Kandilli\'den kontrol edelim, veri var mı?',
          'time': '14:30',
          'isMe': false,
        },
      ];
    });

    // Scroll to bottom
    WidgetsBinding.instance.addPostFrameCallback((_) {
      if (_scrollController.hasClients) {
        _scrollController.jumpTo(_scrollController.position.maxScrollExtent);
      }
    });
  }

  void _sendMessage() {
    if (_messageController.text.trim().isEmpty || !_canSendMessage) return;

    setState(() {
      _messages.add({
        'sender': 'Sen',
        'message': _messageController.text.trim(),
        'time': '${DateTime.now().hour}:${DateTime.now().minute.toString().padLeft(2, '0')}',
        'isMe': true,
      });
      _messageController.clear();
      _canSendMessage = false;
      _remainingSeconds = 15;
    });

    // Scroll to bottom
    WidgetsBinding.instance.addPostFrameCallback((_) {
      if (_scrollController.hasClients) {
        _scrollController.animateTo(
          _scrollController.position.maxScrollExtent,
          duration: Duration(milliseconds: 300),
          curve: Curves.easeOut,
        );
      }
    });

    // Start countdown
    _timer = Timer.periodic(Duration(seconds: 1), (timer) {
      setState(() {
        _remainingSeconds--;
        if (_remainingSeconds <= 0) {
          _canSendMessage = true;
          _timer?.cancel();
        }
      });
    });
  }

  @override
  void dispose() {
    _messageController.dispose();
    _scrollController.dispose();
    _timer?.cancel();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.grey[100],
      appBar: AppBar(
        backgroundColor: Color(0xFFFF3333),
        elevation: 0,
        leading: IconButton(
          icon: Icon(Icons.arrow_back, color: Colors.white),
          onPressed: () => Navigator.pop(context),
        ),
        title: Row(
          children: [
            Container(
              width: 40,
              height: 40,
              decoration: BoxDecoration(
                color: Colors.white.withOpacity(0.2),
                borderRadius: BorderRadius.circular(10),
              ),
              child: Center(
                child: Text(
                  widget.room['city'][0],
                  style: TextStyle(
                    fontSize: 18,
                    fontWeight: FontWeight.bold,
                    color: Colors.white,
                  ),
                ),
              ),
            ),
            SizedBox(width: 12),
            Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Text(
                  widget.room['city'],
                  style: TextStyle(
                    fontSize: 17,
                    fontWeight: FontWeight.bold,
                    color: Colors.white,
                  ),
                ),
                Text(
                  '${widget.room['memberCount']} üye',
                  style: TextStyle(
                    fontSize: 12,
                    color: Colors.white.withOpacity(0.9),
                  ),
                ),
              ],
            ),
          ],
        ),
      ),
      body: Column(
        children: [
          // Mesajlar
          Expanded(
            child: ListView.builder(
              controller: _scrollController,
              padding: EdgeInsets.all(16),
              itemCount: _messages.length,
              itemBuilder: (context, index) {
                return _buildMessageBubble(_messages[index]);
              },
            ),
          ),

          // Mesaj gönderme alanı
          Container(
            padding: EdgeInsets.all(16),
            decoration: BoxDecoration(
              color: Colors.white,
              boxShadow: [
                BoxShadow(
                  color: Colors.black.withOpacity(0.1),
                  blurRadius: 4,
                  offset: Offset(0, -2),
                ),
              ],
            ),
            child: SafeArea(
              child: Column(
                children: [
                  // Countdown timer
                  if (!_canSendMessage)
                    Container(
                      margin: EdgeInsets.only(bottom: 12),
                      padding: EdgeInsets.symmetric(horizontal: 12, vertical: 8),
                      decoration: BoxDecoration(
                        color: Colors.orange.withOpacity(0.1),
                        borderRadius: BorderRadius.circular(8),
                        border: Border.all(color: Colors.orange.withOpacity(0.3)),
                      ),
                      child: Row(
                        mainAxisAlignment: MainAxisAlignment.center,
                        children: [
                          Icon(Icons.timer, color: Colors.orange, size: 18),
                          SizedBox(width: 8),
                          Text(
                            'Yeni mesaj göndermek için $_remainingSeconds saniye bekleyin',
                            style: TextStyle(
                              color: Colors.orange[800],
                              fontSize: 12,
                              fontWeight: FontWeight.w600,
                            ),
                          ),
                        ],
                      ),
                    ),

                  // Input ve gönder butonu
                  Row(
                    children: [
                      Expanded(
                        child: TextField(
                          controller: _messageController,
                          enabled: _canSendMessage,
                          decoration: InputDecoration(
                            hintText: _canSendMessage 
                              ? 'Mesajınızı yazın...' 
                              : 'Lütfen bekleyin...',
                            hintStyle: TextStyle(color: Colors.grey[400]),
                            filled: true,
                            fillColor: Colors.grey[50],
                            border: OutlineInputBorder(
                              borderRadius: BorderRadius.circular(25),
                              borderSide: BorderSide.none,
                            ),
                            contentPadding: EdgeInsets.symmetric(
                              horizontal: 20,
                              vertical: 12,
                            ),
                          ),
                          maxLines: null,
                          textCapitalization: TextCapitalization.sentences,
                        ),
                      ),
                      SizedBox(width: 12),
                      Container(
                        width: 48,
                        height: 48,
                        decoration: BoxDecoration(
                          color: _canSendMessage && _messageController.text.isNotEmpty
                            ? Color(0xFFFF3333)
                            : Colors.grey[300],
                          shape: BoxShape.circle,
                        ),
                        child: IconButton(
                          icon: Icon(Icons.send, color: Colors.white, size: 20),
                          onPressed: _canSendMessage ? _sendMessage : null,
                        ),
                      ),
                    ],
                  ),
                ],
              ),
            ),
          ),
        ],
      ),
    );
  }

  Widget _buildMessageBubble(Map<String, dynamic> message) {
    final isMe = message['isMe'] as bool;
    return Padding(
      padding: EdgeInsets.only(bottom: 12),
      child: Row(
        mainAxisAlignment: isMe ? MainAxisAlignment.end : MainAxisAlignment.start,
        crossAxisAlignment: CrossAxisAlignment.end,
        children: [
          if (!isMe) ...[
            CircleAvatar(
              radius: 16,
              backgroundColor: Color(0xFFFF3333),
              child: Text(
                message['sender'][0],
                style: TextStyle(
                  color: Colors.white,
                  fontSize: 14,
                  fontWeight: FontWeight.bold,
                ),
              ),
            ),
            SizedBox(width: 8),
          ],
          Flexible(
            child: Column(
              crossAxisAlignment: isMe ? CrossAxisAlignment.end : CrossAxisAlignment.start,
              children: [
                if (!isMe)
                  Padding(
                    padding: EdgeInsets.only(left: 8, bottom: 4),
                    child: Text(
                      message['sender'],
                      style: TextStyle(
                        fontSize: 12,
                        fontWeight: FontWeight.w600,
                        color: Colors.grey[700],
                      ),
                    ),
                  ),
                Container(
                  padding: EdgeInsets.symmetric(horizontal: 16, vertical: 10),
                  decoration: BoxDecoration(
                    color: isMe ? Color(0xFFFF3333) : Colors.white,
                    borderRadius: BorderRadius.only(
                      topLeft: Radius.circular(isMe ? 16 : 4),
                      topRight: Radius.circular(isMe ? 4 : 16),
                      bottomLeft: Radius.circular(16),
                      bottomRight: Radius.circular(16),
                    ),
                    boxShadow: [
                      BoxShadow(
                        color: Colors.black.withOpacity(0.05),
                        blurRadius: 4,
                        offset: Offset(0, 2),
                      ),
                    ],
                  ),
                  child: Text(
                    message['message'],
                    style: TextStyle(
                      color: isMe ? Colors.white : Colors.black87,
                      fontSize: 15,
                    ),
                  ),
                ),
                SizedBox(height: 4),
                Padding(
                  padding: EdgeInsets.symmetric(horizontal: 8),
                  child: Text(
                    message['time'],
                    style: TextStyle(
                      fontSize: 11,
                      color: Colors.grey[500],
                    ),
                  ),
                ),
              ],
            ),
          ),
          if (isMe) SizedBox(width: 40),
          if (!isMe) SizedBox(width: 40),
        ],
      ),
    );
  }
}
