/*
 * Copyright © 2013-2016 The Nxt Core Developers.
 * Copyright © 2016-2017 Jelurida IP B.V.
 *
 * See the LICENSE.txt file at the top-level directory of this distribution
 * for licensing information.
 *
 * Unless otherwise agreed in a custom licensing agreement with Jelurida B.V.,
 * no part of the Nxt software, including this file, may be copied, modified,
 * propagated, or distributed except according to the terms contained in the
 * LICENSE.txt file.
 *
 * Removal or modification of this copyright notice is prohibited.
 *
 */

/*
 * Copyright © 2018 Apollo Foundation
 */

package com.apollocurrency.aplwallet.apl.util.env;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.UUID;

public class DefaultDirProvider implements DirProvider {

    @Override
    public boolean isLoadPropertyFileFromUserDir() {
        return false;
    }

    @Override
    public void updateLogFileHandler(Properties loggingProperties) {}

    @Override
    public String getDbDir(String dbRelativeDir, UUID chainId, boolean chainIdFirst) {
        String chainIdDir = chainId == null ? "" : String.valueOf(chainId);
        Path dbDirRelativePath = Paths.get(dbRelativeDir);
        Path userHomeDirPath = Paths.get(getUserHomeDir());
        Path dbPath;
        if (chainIdFirst) {
            dbPath = userHomeDirPath
                    .resolve(chainIdDir)
                    .resolve(dbDirRelativePath);
        } else {
            dbPath = userHomeDirPath
                    .resolve(dbDirRelativePath)
                    .resolve(chainIdDir);
        }
        return dbPath.toString();
    }


    @Override
    public File getLogFileDir() {
        return new File(getUserHomeDir(), "logs");
    }

    @Override
    public String getUserHomeDir() {
        return System.getProperty("user.home");
        //return Paths.get(".").toAbsolutePath().getParent().toString();
    }

    @Override
    public File getBinDirectory() {
        String res = this.getClass().getClassLoader().getResource("").getPath();
        return new File(res);
    }

    @Override
    public File getKeystoreDir(String keystoreDir) {
        return new File(getUserHomeDir(), keystoreDir);
    }    

    @Override
    public String getSysConfigDirectory() {
        return "/etc/apollo";
    }

    @Override
    public String getUserConfigDirectory() {
        return getUserHomeDir()+"/.apollo";
    }
 }
