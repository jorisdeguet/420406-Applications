public interface Service {

    void ajoutQuestion(VDQuestion question);

    void ajoutVote(VDVote vote);

    List<VDQuestion> getAllQuestions();

    Map<Integer, Integer> distributionPour(VDQuestion question);

    double moyennePour(VDQuestion question);

    double ecartTypePour(VDQuestion question);

    String nomEtudiant();
}
