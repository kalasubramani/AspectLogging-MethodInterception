package main.commeproject.proxies;

import main.commeproject.model.UserComment;

public interface ICommentNotificationProxy {
  void sendComment(UserComment comment);
}
