## Hibernate Basic configuration 

We have added the hibernate-core and entityManager dependency of hibernate.
Then we created the hibernate configuration file, and declared the:

        * database instance, dialect, 
        * show sql

We created @Entity classes, @Embeddable class.

Other annotations are:

        * @Entity(name=
        * @Basic(
        * @Transient
        * @Column(name=
        * @AttributeOverrides({@AttributeOverride(name="", column=@Column(name=""...
        * @ID
        * @EmbeddedId
        * @GeneratedValue(strategy=Generation.Auto)
        * @Temporal(TemporalType.Date)
        * @Lob

This project contains examples of simple java application where we have saved:

        * UserDetails
         * Address

in the same table as Embedded objects.

For more complex object relations go to the hibernate2 project.
