package main.commeproject.repositories;

import main.commeproject.model.UserComment;

public interface ICommentRepository {
  void storeComment(UserComment comment);
}
