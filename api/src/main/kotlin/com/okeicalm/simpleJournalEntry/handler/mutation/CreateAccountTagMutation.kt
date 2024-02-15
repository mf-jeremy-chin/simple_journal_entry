package com.okeicalm.simpleJournalEntry.handler.mutation

import com.expediagroup.graphql.server.operations.Mutation
import com.okeicalm.simpleJournalEntry.handler.type.AccountTagType
import com.okeicalm.simpleJournalEntry.usecase.account.AccountTagCreateUseCase
import com.okeicalm.simpleJournalEntry.usecase.account.AccountTagCreateUseCaseInput
import org.springframework.stereotype.Component

data class CreateAccountTagInput(val accountID: Int, val name: String)

@Component
class CreateAccountTagMutation(private val accountCreateTagUseCase: AccountTagCreateUseCase) : Mutation {
    fun createAccountTag(input: CreateAccountTagInput): AccountTagType {
        val output = accountCreateTagUseCase.call(
            AccountTagCreateUseCaseInput(
                name = input.name,
                accountId = input.accountID.toLong()
            )
        )
        return AccountTagType(output.accountTag)
    }
}
