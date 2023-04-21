package com.automationexercise.utils;

import io.qameta.allure.ConfigurationBuilder;
import io.qameta.allure.Extension;
import io.qameta.allure.ReportGenerator;
import io.qameta.allure.allure1.Allure1Plugin;
import io.qameta.allure.allure2.Allure2Plugin;
import io.qameta.allure.category.CategoriesPlugin;
import io.qameta.allure.category.CategoriesTrendPlugin;
import io.qameta.allure.context.FreemarkerContext;
import io.qameta.allure.context.JacksonContext;
import io.qameta.allure.context.MarkdownContext;
import io.qameta.allure.context.RandomUidContext;
import io.qameta.allure.core.*;
import io.qameta.allure.duration.DurationPlugin;
import io.qameta.allure.duration.DurationTrendPlugin;
import io.qameta.allure.environment.Allure1EnvironmentPlugin;
import io.qameta.allure.executor.ExecutorPlugin;
import io.qameta.allure.history.HistoryPlugin;
import io.qameta.allure.history.HistoryTrendPlugin;
import io.qameta.allure.idea.IdeaLinksPlugin;
import io.qameta.allure.influxdb.InfluxDbExportPlugin;
import io.qameta.allure.launch.LaunchPlugin;
import io.qameta.allure.mail.MailPlugin;
import io.qameta.allure.owner.OwnerPlugin;
import io.qameta.allure.prometheus.PrometheusExportPlugin;
import io.qameta.allure.retry.RetryPlugin;
import io.qameta.allure.retry.RetryTrendPlugin;
import io.qameta.allure.severity.SeverityPlugin;
import io.qameta.allure.status.StatusChartPlugin;
import io.qameta.allure.suites.SuitesPlugin;
import io.qameta.allure.summary.SummaryPlugin;
import io.qameta.allure.tags.TagsPlugin;
import io.qameta.allure.timeline.TimelinePlugin;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Allure {

    public static void onGenerateAllureReport() {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                try {
                    final List<Extension> extensions = Arrays.asList(new JacksonContext(), new MarkdownContext(), new FreemarkerContext(), new RandomUidContext(), new MarkdownDescriptionsPlugin(), new RetryPlugin(), new RetryTrendPlugin(), new TagsPlugin(), new SeverityPlugin(), new OwnerPlugin(), new IdeaLinksPlugin(), new CategoriesPlugin(), new CategoriesTrendPlugin(), new HistoryPlugin(), new HistoryTrendPlugin(), new DurationPlugin(), new DurationTrendPlugin(), new StatusChartPlugin(), new TimelinePlugin(), new SuitesPlugin(), new TestsResultsPlugin(), new AttachmentsPlugin(), new MailPlugin(), new InfluxDbExportPlugin(), new PrometheusExportPlugin(), new SummaryPlugin(), new ExecutorPlugin(), new LaunchPlugin(), new Allure1Plugin(), new Allure1EnvironmentPlugin(), new Allure2Plugin(), new ReportWebPlugin());
                    Configuration configuration = (new ConfigurationBuilder()).fromExtensions(extensions).build();
                    Path resultDi = Paths.get("target/allure-results");
                    Path outDir = Paths.get("target/allure-report");
                    new ReportGenerator(configuration).generate(outDir, resultDi);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
