CREATE OR REPLACE TRIGGER delete_anonymous_users_trigger
    AFTER INSERT ON utilisateur
    FOR EACH ROW
BEGIN
    DECLARE
        id_utilisateur NUMBER;
    BEGIN
        id_utilisateur := to_number(:NEW.id);

        IF (:NEW.nom = 'Anonymous' AND :NEW.prenom = 'Anonymous') THEN
            DELETE FROM pack
            WHERE id_panier IN (SELECT id_panier
                                FROM panier
                                WHERE utilisateur_id = id_utilisateur);

            DELETE FROM panier
            WHERE utilisateur_id = id_utilisateur;

            DELETE FROM utilisateur
            WHERE id = id_utilisateur;
        END IF;
    END;
END delete_anonymous_users_trigger;

