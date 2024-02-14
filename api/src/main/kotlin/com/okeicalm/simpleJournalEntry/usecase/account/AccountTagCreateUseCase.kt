package com.okeicalm.simpleJournalEntry.usecase.account

import com.okeicalm.simpleJournalEntry.entity.AccountTag
import com.okeicalm.simpleJournalEntry.repository.AccountTagRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

// this is teh Long that's being stupid, right?
// but we have Long in other plaecs... wtf?
// or is it on the output...?
// OH use case is separate, check the mutation side!
data class AccountTagCreateUseCaseInput(val name: String, val accountId: Long)
data class AccountTagCreateUseCaseOutput(val account: AccountTag)

interface AccountTagCreateUseCase {
    fun call(input: AccountTagCreateUseCaseInput): AccountTagCreateUseCaseOutput
}

@Service
class AccountTagCreateUseCaseImpl(private val accountRepository: AccountTagRepository) : AccountTagCreateUseCase {
    @Transactional
    override fun call(input: AccountTagCreateUseCaseInput): AccountTagCreateUseCaseOutput {
        val account = AccountTag(
            name = input.name,
            account_id = input.accountId
        )
        return AccountTagCreateUseCaseOutput(accountRepository.create(account))
    }
}
