package com.wespeak.core.datamanager;

import com.wespeak.core.Vote;

public interface DataManager
{
    //
    // user actions
    //
    void heartbeat(long now, String userId, long until);
    void submit   (long now, String userId, String statementId, String text, long until, int numEligibleSupporters, int numSupportNeeded);
    void support  (String userId, String statementId);
    void vote     (String userId, String statementId, Vote vote);

    //
    // engine actions
    //
    void timeoutUser     (String userId);
    void timeoutStatement(String statementId);
    void beginVote       (long now, String statementId, long until, int numEligibleVoters, int numVotesNeeded, int numYesesNeeded);
    void endVote         (String statementId);

    //
    // queries
    //
    boolean  isUserActive              (String userId);

    boolean  isStatementActive         (String statementId);
    boolean  isVoting                  (String statementId);
    boolean  isAccepted                (String statementId);
    boolean  isRejected                (String statementId);

    String   getText                   (String statementId);
    String   getSubmitter              (String statementId);
    long     getSubmissionTime         (String statementId);
    long     getSubmissionTTL          (long now, String statementId);
    long     getVoteBeginTime          (String statementId);
    long     getVoteTTL                (long now, String statementId);

    long     getUserActiveTime         (String userId);
    long     getUserTTL                (long now, String userId);

    boolean  canSupport                (String userId, String statementId);
    boolean  canVote                   (String userId, String statementId);

    int      getNumEligibleSupporters  (String statementId);
    int      getNumSupportNeeded       (String statementId);
    int      getNumSupport             (String statementId);
    int      getNumEligibleVoters      (String statementId);
    int      getNumVotesNeeded         (String statementId);
    int      getNumVotes               (String statementId);
    int      getNumYesesNeeded         (String statementId);
    int      getNumYeses               (String statementId);

    String   getOldestActiveUserId     ();
    String   getOldestActiveStatementId();

    boolean  isSupported               (String userId, String statementId);
    Vote     getVote                   (String userId, String statementId);

    String[] getSubmittedStatementIds  (String userId);
    String[] getSupportedStatementsIds (String userId);
    String[] getVotedStatementIds      (String userId);
}
