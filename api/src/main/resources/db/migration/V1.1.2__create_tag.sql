use simple_journal_entry_db;

create table account_tag (
    id bigint not null primary key auto_increment,
    name varchar(128) not null,
    account_id bigint not null,
    foreign key fk_tag_account (account_id) references accounts(id)
);
